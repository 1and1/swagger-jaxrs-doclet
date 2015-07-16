package fixtures.format;

/**
 * The Data represents a simple pojo for testing produces/consumes
 * @version $Id$
 * @author conor.roche
 */
@SuppressWarnings("javadoc")
public class Data {

	/**
	 * @format date
	 */
	@SuppressWarnings("unused")
	private String formatFieldTag;

	private String formatGetterTag;

	public Data() {
	}

	public Data(String formatFieldTag, String formatGetterTag) {
		super();
		this.formatFieldTag = formatFieldTag;
		this.formatGetterTag = formatGetterTag;
	}

	/**
	 * @format date-time
	 */
	public String getFormatGetterTag() {
		return this.formatGetterTag;
	}

}
