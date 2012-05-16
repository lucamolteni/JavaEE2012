package it.vigorelli;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class WorkspaceBean implements Serializable {
    private List<String> conversation = new ArrayList<String>();

    public List<String> getConversations() {
        return conversation;
    }
}
