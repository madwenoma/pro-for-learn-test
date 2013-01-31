package com.lee.learn.commons.collections;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
/**
 * bean for @see ComparatorTests
 * @author user
 *
 */
public class Issue {
	private long id;
	private String severity;
	private String owner;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Issue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Issue(long id, String severity, String owner) {
		super();
		this.id = id;
		this.severity = severity;
		this.owner = owner;
	}
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
					.append("id", id)
					.append("severity", severity)
					.append("owner", owner).toString();
	}
}