package src.GitGameEngine;


public class GitEngineMessage {
    private String message;
    private Boolean success; // FIXME, maybe status?

    public String getMessage() {
        return message;
    }

    public boolean getSuccess() {
        return success;
    }

    public GitEngineMessage setMessage(String message) {
        this.message = message;
        return this;
    }

    public GitEngineMessage setSuccess(Boolean success) {
        this.success = success;
        return this;
    }
}
