public class Event extends Task {
	protected String details;

	public Event(String description, String details) {
		super(description);
		this.details = details;
	}

	@Override
	public String toString() {
		return "[E]" + super.toString() + " (at: " + this.details + ")";
	}
}
