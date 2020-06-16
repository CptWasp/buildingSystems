package sample;

public class ObjectFromBD {
    private String id;
    private String object_name;
    private String user_name;
    private String comment;
    private String link;
    private String status;

    public ObjectFromBD(String id, String object_name, String user_name, String comment, String link, String status) {
        this.id = id;
        this.object_name = object_name;
        this.user_name = user_name;
        this.comment = comment;
        this.link = link;
        this.status = status;
    }

    public ObjectFromBD(){}

//    ###########

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getObject_name() {
        return object_name;
    }

    public void setObject_name(String object_name) {
        this.object_name = object_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }






}

