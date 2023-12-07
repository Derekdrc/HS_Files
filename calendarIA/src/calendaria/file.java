package calendaria;

public class file {
    private String date;
    private String title;
    private String category;
    
    
    public file(String date, String title, String category){
        this.date = date;
        this.title = title; 
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
}
