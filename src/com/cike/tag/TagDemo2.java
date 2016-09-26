package com.cike.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 带有标签主体
 * 
 * @author CIKE
 *
 */
public class TagDemo2 extends SimpleTagSupport {

	private PageContext pc;

	@Override
	public void doTag() throws JspException, IOException {
		JspFragment jf = getJspBody();
		jf.invoke(pc.getOut());
	}

	@Override
	public void setJspContext(JspContext pc) {
		this.pc = (PageContext) pc;
	}

}
