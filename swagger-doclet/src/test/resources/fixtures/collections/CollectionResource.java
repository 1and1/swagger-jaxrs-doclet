package fixtures.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * The CollectionResource represents a jaxrs that returns collections and objects
 * that hold collections
 * @version $Id$
 * @author conor.roche
 */
@Path("/collections")
@SuppressWarnings("javadoc")
public class CollectionResource {

	@GET
	public CollectionHolder getCollectionHolder() {
		List<CollectionItem> listItems = new ArrayList<CollectionItem>();
		listItems.add(new CollectionItem("test"));
		Set<CollectionItem> setItems = new HashSet<CollectionItem>();
		setItems.add(new CollectionItem("test2"));

		List<String> listStrings = new ArrayList<String>();
		listStrings.add("test3");
		Set<String> setStrings = new HashSet<String>();
		setStrings.add("test4");

		CollectionHolder resp = new CollectionHolder();
		resp.setCollectionItems(listItems);
		resp.setListItems(listItems);
		resp.setSetItems(setItems);

		resp.setCollectionStrings(listStrings);
		resp.setListStrings(listStrings);
		resp.setSetStrings(setStrings);

		return resp;
	}

	@GET
	@Path("/items")
	public Collection<CollectionItem> getItems() {
		List<CollectionItem> listItems = new ArrayList<CollectionItem>();
		listItems.add(new CollectionItem("test"));
		return listItems;
	}

	@GET
	@Path("/strings")
	public Collection<String> getStrings() {
		List<String> listItems = new ArrayList<String>();
		listItems.add("test");
		return listItems;
	}

	@POST
	@Path("/listofstrings")
	public void setListOfStrings(List<String> items) {
		// noop
	}

	@POST
	@Path("/listofints")
	public void setListOfInts(List<Integer> items) {
		// noop
	}

	@GET
	@Path("/setofstrings")
	public Set<String> getSetOfStrings() {
		return null;
	}

	@POST
	@Path("/setofstrings")
	public void setSetOfStrings(Set<String> items) {
		// noop
	}

	@POST
	@Path("/collectionofstrings")
	public void setCollectionOfStrings(Collection<String> items) {
		// noop
	}

	@POST
	@Path("/listofitems")
	public void setListOfItems(List<CollectionItem> items) {
		// noop
	}

}
