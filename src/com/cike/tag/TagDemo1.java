package com.cike.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 对外输出Hello
 * @author CIKE
 *
 */
public class TagDemo1 extends SimpleTagSupport{

	private PageContext pc;

	@Override
	public void doTag() throws JspException, IOException {
		pc.getOut().write("Hello");
	}

	@Override
	public void setJspContext(JspContext pc) {
		this.pc = (PageContext) pc;
	}

}
