package veterinerProject.w34.core.results;

public class ErrorResult extends Result{

    public ErrorResult(String message) {
        super(message, false);
    }

    public ErrorResult(){
        super(false);
    }

}
