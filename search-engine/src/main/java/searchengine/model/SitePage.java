package searchengine.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "site")
@NoArgsConstructor
@Setter
@Getter
public class SitePage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull
    private Status status;

    @Column(name = "status_time", nullable = false)
    private Timestamp statusTime;

    @Column(name = "last_error", columnDefinition = "TEXT")
    private String lastError;

    @Column(nullable = false, length = 255)
    @NotNull
    private String url;

    @Column(nullable = false, length = 255)
    @NotNull
    private String name;

    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Page> pages;

    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lemma> lemmas;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Status getStatus(){
        return status;
    }
    public void setStatus(Status status){
        this.status = status;
    }
    public Timestamp getStatusTime(){
        return statusTime;
    }
    public void setStatusTime(Timestamp statusTime){
        this.statusTime = statusTime;
    }
    public String getLastError(){
        return lastError;
    }
    public void setLastError(String lastError){
        this.lastError = lastError;
    }
    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public List<Page> getPages(){
        return pages;
    }
    public void setPages(List<Page> pages){
        this.pages = pages;
    }
    public List<Lemma> getLemmas(){
        return lemmas;
    }
    public void setLemmas(List<Lemma> lemmas){
        this.lemmas = lemmas;
    }
    public int getSize(){
        return pages.size();
    }

}