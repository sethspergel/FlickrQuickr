package com.sethsoft.flickr;

import java.util.Map;


/** 
* Photo represents the individual photo object returned by Flickr
*
*/
public class Photo {

	private String _link;
	private String _date_taken;
	private String _description;
	private String _published;
	private String _author;
	private String _author_id;
	private String _tags;
	private String _title;
	private Map<String, String> _media;
 
	
	
	public String getTitle() {
		return _title;
	}

	public void setTitle(String _title) {
		this._title = _title;
	}

	public String getLink() {
		return _link;
	}

	public void setLink(String _link) {
		this._link = _link;
	}

	public String getDate_taken() {
		return _date_taken;
	}

	public void setDate_taken(String _date_taken) {
		this._date_taken = _date_taken;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String _description) {
		this._description = _description;
	}

	public String getPublished() {
		return _published;
	}

	public void setPublished(String _published) {
		this._published = _published;
	}

	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String _author) {
		this._author = _author;
	}

	public String getAuthor_id() {
		return _author_id;
	}

	public void setAuthor_id(String _author_id) {
		this._author_id = _author_id;
	}

	public String getTags() {
		return _tags;
	}

	public void setTags(String _tags) {
		this._tags = _tags;
	}
	
	public Map<String, String> getMedia() {
		return _media;
	}

	public void setMedia(Map<String, String> _media) {
		this._media = _media;
	}

}
