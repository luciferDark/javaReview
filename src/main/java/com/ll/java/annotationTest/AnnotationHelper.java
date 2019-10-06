package com.ll.java.annotationTest;

import com.ll.java.utils.Log;

@Author(name = "kylin", sex = 1)
public class AnnotationHelper {
    public void start() {
        Log.log(this.getClass().getName());
        Author author = this.getClass().getAnnotation(Author.class);
        if (author != null) {
            Log.log("Author:" + author.name() +"--" + author.sex());
        }
    }
}
