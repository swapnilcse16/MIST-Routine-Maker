/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routinemaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class ScheduleFinder {
    public static Object o[][];
    
    ///if teacher then teacherOrRoom = 8, if room then teacherOrRoom=2
    static void findSchedule(String term, String name, int teacherOrRoom){
        Connection conn = JConnection.ConnecrDb();
        ArrayList<FacRoomProfile> facRoom = new ArrayList<>();
        ArrayList<Integer>codes = new ArrayList<>();
        ArrayList<Integer>sections = new ArrayList<>();
        
        o = new Object[7][7];
        o[0][0] = name;
        o[1][0] = "SUN";
        o[2][0] = "MON";
        o[3][0] = "TUE";
        o[4][0] = "WED";
        o[5][0] = "THU";
        
        try{
            String sql = "SELECT code, section FROM courses WHERE term = ? AND (t1=? OR t2=? OR t3=? OR t4=? OR t5=? OR t6=? OR t7=? OR t8=?)";
            if(teacherOrRoom==2)    sql = "SELECT code, section FROM courses WHERE term = ? AND (r1=? OR r2=?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, term);
            for(int i=1; i<=teacherOrRoom; i++) ps.setString(i+1, name);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                codes.add(rs.getInt(1));
                sections.add(rs.getInt(2));
                System.out.println(rs.getInt(1) + " " + rs.getInt(2));
            }
            ps.close();
            rs.close();
        }catch(Exception e){
            System.out.println("Schedule Finder class, Error-1");
        }
        
        try{
            String sql = "SELECT code, sec, color FROM routine WHERE term = ? AND (code=? AND sec=?)";
            for(int i=0; i<codes.size(); i++){
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, term);
                ps.setInt(2, codes.get(i));
                ps.setInt(3, sections.get(i));
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    FacRoomProfile f = new FacRoomProfile(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                    facRoom.add(f);
                }
                ps.close();
                rs.close();
            }
        }catch(Exception e){
            System.out.println("Schedule Finder class, Error-2");
        }
        
        for(int i=0; i<7; i++){
            for(int j=1; j<=6; j++) o[i][j] = "";
        }
        for(int j=0; j<7; j++) o[6][j] = "-----------------------------------------------";  
        o[0][1] = term;
        
        int color = 0;
        for(int i=1; i<=5; i++){
            for(int j=1; j<=6; j++){
                for(int k=0; k<facRoom.size(); k++){
                    if(facRoom.get(k).color != color)   continue;
                    String s = facRoom.get(k).code + "" + (char)(facRoom.get(k).sec + 65);
                    o[i][j] = s;
                    System.out.println("Code: "+facRoom.get(k).code+" Color: "+facRoom.get(k).color+" ("+i+","+j+")");
                    break;
                }
                color++;
            }
        }
    }
}
