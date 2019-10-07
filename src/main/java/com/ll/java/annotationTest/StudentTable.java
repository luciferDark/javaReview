package com.ll.java.annotationTest;

@SQLTest.DBTable(name = "STUDENT")
public class StudentTable {

    @SQLTest.SQLString(name = "ID", value = 50,
            constraint = @SQLTest.Constraints(primaryKey = true))
    private String id;

    @SQLTest.SQLString(name = "STUDENT_NAME", value = 30)
    private String name;

    @SQLTest.SQLInt(name = "STUDENT_AGE")
    private int age;

    @SQLTest.SQLString(name = "STUDENT_DESCRIPTION", value = 150,
            constraint = @SQLTest.Constraints(isNull = true))
    private String description;
}
