/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teammanagement;

import java.util.Date;

/**
 *
 * @author Threading
 */
public class ProgrammerData {
    int id;
    String FileName;
    String comment;
    Date time;

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }
    

    public int getId() {
        return id;
    }

    public String getFileName() {
        return FileName;
    }

    public String getComment() {
        return comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFileName(String FileName) {
        this.FileName = FileName;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
}
