class SwitchRecordsRunner {

    sealed interface CustomerMessage permits Message, Feedback {
    }

    final record Message(String text) implements CustomerMessage {
    }

    final record Feedback(double rating, String description) implements CustomerMessage {
    }

    record SupportRequest(String user, CustomerMessage message) {
    }

    public static void main(String[] args) {
        CustomerMessage customerMessage = new Message("I need help");

        String response = switch (customerMessage) {
            case Message(String text) -> "Processing message: " + text;
            case Feedback(double rating, String description) ->
                "Processing feedback rating: " + rating + " stars" + " with description: " + description;
            // case Message message -> message.text();
            // case Feedback feedback -> "Processing feedback rating: " + feedback.rating()
            // + " stars" + " with description: " + feedback.description();
            // default -> "Unknown message type";
        };
        System.out.println(response);

        SupportRequest supportRequest = new SupportRequest("John Doe", new Feedback(4.5, "Great service!"));
        // System.out.println(supportRequest);
        String responseMessage = switch (supportRequest) {
            case SupportRequest(String user, Message message) -> "Support request from " + user + ": " + message.text();
            case SupportRequest(String user, Feedback feedback) ->
                "Support request from " + user + ": Feedback rating: " + feedback.rating() + " stars"
                        + " with description: " + feedback.description();
        };
        System.out.println(responseMessage);
    }
}
