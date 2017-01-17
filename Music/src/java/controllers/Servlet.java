/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import connector.MusicDB;
import java.sql.Date;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import objects.SongList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

 
@Controller
public class Servlet {
 
    //Initial work from the controller. Send to the index initially.
    @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "index";
    }
    
    
    //Second page. Will display the selected songs.
    @RequestMapping(value = "/view.htm", method = RequestMethod.POST)
    public String display(ModelMap modelMap, @RequestParam String button, @RequestParam String artist, HttpServletRequest request) {
        SongList list = MusicDB.getAllSongs();
        HttpSession session = request.getSession(true);
        session.setAttribute("masterList", list);
        
        switch (button) {
            case "Search Artist": 
                modelMap.put("list", list.getSongs(artist));
                return "view";
            case "Show All Songs":
                modelMap.put("list", list.getSongs());
                return "view";
            case "Add Song":
                return "add";
            case "Delete Song":
                modelMap.put("list", list.getSongs());
                return "delete";
            default:
                break;
        }
        
        return "view";
    }
    
    
    //Sort page. Will display the songs in a sorted order.
    @RequestMapping(value = "/list.htm", method = RequestMethod.POST)
    public String sort(ModelMap modelMap, @RequestParam String button, HttpServletRequest request) {
        
        HttpSession session = request.getSession(true);
        SongList masterList = (SongList) session.getAttribute("masterList");
        
        switch (button) {
            case "Sort by Name":
                masterList.sortByName();
                break;
            case "Sort by Artist":
                masterList.sortByArtist();
                break;
            case "Sort by Release Date":
                masterList.sortByDate();
                break;
            case "Sort by Rating":
                masterList.sortByRating();
                break;
            default:
                return "index";
        }
        
        
        modelMap.put("list", masterList.getSongs());
        return "view";
    }
    
    
    //Add page. Will allow the user to add a song directly to the SQL server.
    @RequestMapping(value = "/add.htm", method = RequestMethod.POST)
    public String add(ModelMap modelMap, @RequestParam String button, HttpServletRequest request) throws ParseException {
        
        if(button.equals("Submit")) {
            try {
                String name = request.getParameter("name");
                String artist = request.getParameter("artist");
                Date date =  Date.valueOf(request.getParameter("date"));
                double rating = Double.parseDouble(request.getParameter("rating"));
                

                String message = MusicDB.addSong(name, artist, date, rating);
                modelMap.put("message", message);
                
                return "add";
            }
            catch(NumberFormatException e) {
                String message = "Bad values. Song not added!";
                modelMap.put("message", message);
                return "add";
            }
        }
        else {
            return "index";
        }
    }
    
    
    //Delete page. Will allow the user to delete a song directly from the SQL server.
    @RequestMapping(value = "/delete.htm", method = RequestMethod.POST)
    public String delete(ModelMap modelMap, @RequestParam String button, HttpServletRequest request) {
        String name = (String) request.getParameter("id");
        
        if(button.equals("Delete Selected")) {
            String message = MusicDB.deleteSong(name);
            modelMap.put("message", message);
            SongList list = MusicDB.getAllSongs();
            modelMap.put("list", list.getSongs());
            return "delete";
        }
        else {
            return "index";
        }
    }
}