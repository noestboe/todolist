package todolist.core;

public class TodoItem {

    private String description;
    private boolean checked;

    public TodoItem(String description) {
        this.description = description;
        this.checked = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getChecked(){
        return checked;
    }

    public void toggleChecked() {
        if (checked == true) {
            checked = false;
        } else{
            checked = true;
        }
    }
}