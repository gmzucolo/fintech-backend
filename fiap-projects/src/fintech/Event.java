package fintech;

public class Event {

	private int eventId;
	private String eventType;
	private String eventDescription;
	private String eventDate;
	private Account account;
	private Earning earning;
	private Spending spending;

	public Event() {
	}

	public Event(int eventId, String eventType, String eventDescription, String eventDate, Account account,
			Earning earning, Spending spending) {

		this.eventId = eventId;
		this.eventType = eventType;
		this.eventDescription = eventDescription;
		this.eventDate = eventDate;
		this.account = account;
		this.earning = earning;
		this.spending = spending;

	}

	public int getEventId() {
		return eventId;
	}

	private void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventType() {
		return eventType;
	}

	private void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	private void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventDate() {
		return eventDate;
	}

	private void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	protected void createEvent(int eventId, String eventType, String eventDescription, String eventDate,
			Account account, Earning earning, Spending spending) {
	}

	protected void editEvent(Event event) {
	}

	protected void deleteEvent(Event event) {
	}

}
