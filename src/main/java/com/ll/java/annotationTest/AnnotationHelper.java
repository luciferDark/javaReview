package com.ll.java.annotationTest;

import com.ll.java.utils.Log;

@Author(name = "kylin", sex = 1)
public class AnnotationHelper {
    public void start() {
        testAnnotationSimple();
        testAnnotationOne();
    }

    public void testAnnotationSimple() {
        Log.log(this.getClass().getName());
        Author author = this.getClass().getAnnotation(Author.class);
        if (author != null) {
            Log.log("Author:" + author.name() + "--" + author.sex());
        }
    }

    private void testAnnotationOne() {
        String[] clazzs = new String[]{"com.ll.java.annotationTest.StudentTable"};
        try {
            for (String itemClazz : clazzs) {
                String sqlCreater = SQLTest.TableCreator.createTableSQL(itemClazz);
                Log.log(sqlCreater);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
