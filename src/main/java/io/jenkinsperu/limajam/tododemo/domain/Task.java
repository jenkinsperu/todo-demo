package io.jenkinsperu.limajam.tododemo.domain;

import java.util.Objects;

public class Task {


    private boolean done;

    private String text;

    public Task(String text) {

        this.text=text;
        this.done=false;
    }

    public void done() {
        done=true;
    }


    public boolean isDone() {
        return done;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return done == task.done &&
                Objects.equals(text, task.text);
    }

    @Override
    public int hashCode() {

        return Objects.hash(done, text);
    }
}
