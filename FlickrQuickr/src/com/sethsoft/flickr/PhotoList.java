package com.sethsoft.flickr;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import javax.ws.rs.core.MediaType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


public class PhotoList {

	private static String flickrFeedURL = "http://api.flickr.com/services/feeds/photos_public.gne?format=json&nojsoncallback=1";

	// how long to wait between refreshes of the feed
	// by default, refresh every 10 seconds
	private static long REFRESH_INTERVAL = 10000;

	private static PhotoList photoList = null;
	private static long lastUpdated = 0;

	private String _title;
	private String _link;
	private String _description;
	private String _modified;
	private String _generator;
	private ArrayList<Photo> _items;

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

	public String getDescription() {
		return _description;
	}

	public void setDescription(String _description) {
		this._description = _description;
	}

	public String getModified() {
		return _modified;
	}

	public void setModified(String _modified) {
		this._modified = _modified;
	}

	public String getGenerator() {
		return _generator;
	}

	public void setGenerator(String _generator) {
		this._generator = _generator;
	}

	public ArrayList<Photo> getItems() {
		return _items;
	}

	public void setItems(ArrayList<Photo> _items) {
		this._items = _items;
	}

	public static PhotoList getPhotoList() throws IOException,
			JsonParseException, JsonMappingException {

		// no need to call Flickr every time we want to create a PhotoList,
		// so we will use a singleton and add some caching

		// grab current system time so we can see if we need to refresh cache
		long currentTime = new Date().getTime();

		if (photoList == null) {
			PhotoList.populateList();
			lastUpdated = new Date().getTime();

		} else // check if caching time elapsed
			if ((lastUpdated - currentTime) > REFRESH_INTERVAL) 
		{
			// if cache time has been exceeded, repopulate the list from Flickr
			PhotoList.populateList();
			lastUpdated = new Date().getTime();

		}

		// if we got here without an exception, either we already had a
		// photoList
		// or a new one has just been created and populated.
		
		return photoList;
	}

	private static void populateList() throws IOException, JsonParseException,
			JsonMappingException {

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);

		Client client = Client.create(clientConfig);

		WebResource webResource = client.resource(flickrFeedURL);
		String response = webResource.accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);

		ObjectMapper mapper = new ObjectMapper();
		
		// just in case they send us anything we're not expecting
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);
		
		// it appears Flickr doesn't always send "proper" JSON
		mapper.configure(
				JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);


		PhotoList newPhotoList = mapper.readValue(response, PhotoList.class);
		

		photoList = newPhotoList;
		

	}

	private PhotoList() {
		// make constructor private to ensure we always use singleton
	}

}
