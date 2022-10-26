package routinemaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

public class GapFinder {
    ///teacher=8, room=2
    public static ArrayList<Integer> findGap(String term, String name, int totalSlot, int teacherOrRoom){
        int freq[] = new int[totalSlot];
        ArrayList<Integer> res = new ArrayList<>();
        Connection conn = JConnection.ConnecrDb();
        ArrayList<Integer>levels = new ArrayList<>();
        ArrayList<Integer>codes = new ArrayList<>();
        ArrayList<Integer>sections = new ArrayList<>();
        
        for(int i=0; i<totalSlot; i++)  freq[i] = 0;
        
        try{
            String sql = "SELECT level, code, section FROM courses WHERE term = ? AND (t1=? OR t2=? OR t3=? OR t4=? OR t5=? OR t6=? OR t7=? OR t8=?)";
            if(teacherOrRoom==2)    sql = "SELECT level, section, code FROM courses WHERE term = ? AND (r1=? OR r2=?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, term);
            for(int i=1; i<=teacherOrRoom; i++) ps.setString(i+1, name);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                levels.add(rs.getInt(1));
                codes.add(rs.getInt(2));
                sections.add(rs.getInt(3));
            }
            ps.close();
            rs.close();
        }catch(Exception e){
            System.out.println("Gap Finder class, Error-1");
        }
        
        for(int i=0; i<codes.size(); i++){
            int level = levels.get(i);
            int code = codes.get(i);
            int sec = sections.get(i);
            
            try{
                PreparedStatement ps = conn.prepareStatement("SELECT color FROM ROUTINE where term=? AND level=? AND code=? AND sec=?");
                ps.setString(1, term);
                ps.setInt(2, level);
                ps.setInt(3, code);
                ps.setInt(4, sec);
                
                ResultSet rs = ps.executeQuery();
                while(rs.next())    freq[rs.getInt(1)] = 1;
                ps.close();
                rs.close();
            }catch(Exception e){
                System.out.println("Gap Finder class, Error-2, i: " + i);
            }            
        }
        
        for(int i=0; i<totalSlot; i++){
            if(freq[i]==1)  continue;
            res.add(i);
        }
        
        
        return res;
    }
    
    
    
    public static ArrayList<Integer> findIntersection(ArrayList<Integer>a1, ArrayList<Integer>a2, int totalSlot){
        ArrayList<Integer>res = new ArrayList<>();
        int f[] = new int[totalSlot];
        for(int i=0; i<totalSlot; i++)  f[i]=0;
        for(int i=0; i<a1.size(); i++)  f[a1.get(i)]++;
        for(int i=0; i<a2.size(); i++)  f[a2.get(i)]++;
        for(int i=0; i<totalSlot; i++)  {if(f[i]>1)  res.add(i);}
        return res;
    }
}
