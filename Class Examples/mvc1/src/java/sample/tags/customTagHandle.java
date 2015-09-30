/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.tags;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import static javax.servlet.jsp.tagext.Tag.EVAL_PAGE;

/**
 *
 * @author Hau
 */
public class customTagHandle implements Tag {

     private PageContext pageContext;
    private Tag parent;
    
    @Override
    public void setPageContext(PageContext pc) {
        this.pageContext = pc;
    }

    @Override
    public void setParent(Tag t) {
         this.parent = t;
    }

    @Override
    public Tag getParent() {
         return this.parent;
    }

    @Override
    public int doStartTag() throws JspException {
         JspWriter out = this.pageContext.getOut();
         System.out.println("startTag");
         try {
             out.println("Hello.");
         } catch (IOException ex) {
             ex.printStackTrace();
         }
         
         return EVAL_PAGE;
    }

    @Override
    public int doEndTag() throws JspException {
         JspWriter out = this.pageContext.getOut();
         System.out.println("doEndTag");
         
         try {
             out.println("end");
         } catch (IOException ex) {
             ex.printStackTrace();
         }
         return EVAL_PAGE;
    }

    @Override
    public void release() {
         
    }
}
