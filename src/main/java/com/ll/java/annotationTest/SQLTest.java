package com.ll.java.annotationTest;

import com.ll.java.utils.Log;
import com.ll.java.utils.Util;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SQLTest {
    public static class TableCreator {
        public static final String SPACE = " ";
        public static final String CREATE_TABLE = "CREATE TABLE";
        public static final String NOT_NULL = "NOT NULL";
        public static final String PRIMARY_KEY = "PRIMARY KEY";
        public static final String UNIQUE = "UNIQUE";
        public static final String NEXT_COL = "\n";


        /**
         * 根据注解自动创建sql语句
         * @param clazzName
         * @return
         * @throws ClassNotFoundException
         */
        public static String createTableSQL(String clazzName) throws ClassNotFoundException {
            Class<?> clazz = Class.forName(clazzName);
            DBTable dbTable = clazz.getAnnotation(DBTable.class);

            if (dbTable == null) {
                Log.log("No db table annotations in class:" + clazzName);
                return null;
            }
            String tableName = dbTable.name();
            if (Util.isEmptyString(tableName)) {
                //当没有指定表名，则使用类名作为表名
                tableName = clazz.getSimpleName().toUpperCase();
            }

            List<String> columns = new ArrayList<>();
            for (Field field : clazz.getDeclaredFields()) {
                String columnName = null;
                Annotation[] annotations = field.getDeclaredAnnotations();
                if (annotations.length <= 0) {
                    continue;//没有注解列表名
                }

                for (Annotation annotation : annotations) {
                    if (annotation instanceof SQLInt) {
                        SQLInt sqlInt = (SQLInt) annotation;
                        if (sqlInt.name().length() <= 0) {
                            columnName = field.getName().toUpperCase();
                        } else {
                            columnName = sqlInt.name();
                        }
                        columns.add(columnName + SPACE + "INT"
                                + getConstrains(sqlInt.constraint()));
                        break;//只取第一个拿到的数据库字段的注解
                    } else if (annotation instanceof SQLString) {
                        SQLString sqlString = (SQLString) annotation;
                        if (sqlString.name().length() <= 0) {
                            columnName = field.getName().toUpperCase();
                        } else {
                            columnName = sqlString.name();
                        }
                        columns.add(columnName + SPACE + "VATCHAR("
                                + sqlString.value() + ")"
                                + getConstrains(sqlString.constraint()));
                        break;
                    }
                }
            }
            //构建数据库语句
            StringBuffer createCommand = new StringBuffer();
            createCommand.append(CREATE_TABLE + SPACE
                    + tableName + "(");
            for (String columDef : columns) {
                createCommand.append(NEXT_COL + SPACE
                        + columDef + ",");
            }

            //剪掉最后一个,号
            String tableCreateString = createCommand.toString()
                    .substring(0,createCommand.length() - 1) + ");";
            return tableCreateString;
        }

        /**
         * 获取约束性条件
         *
         * @param constraints
         * @return
         */
        public static String getConstrains(Constraints constraints) {
            StringBuffer constrantBuff = new StringBuffer();
            if (constraints.primaryKey()) {
                constrantBuff.append(SPACE + PRIMARY_KEY);
            }
            if (constraints.unique()) {
                constrantBuff.append(SPACE + UNIQUE);
            }
            if (!constraints.isNull()) {
                constrantBuff.append(SPACE + NOT_NULL);
            }

            Log.log("get Constraints:" + constrantBuff.toString());
            return constrantBuff.toString();
        }
    }

    /**
     * 数据库表注解
     */
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DBTable {
        /**
         * 数据库表名称
         *
         * @return
         */
        String name() default "";
    }

    /**
     * 约束条件
     */
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Constraints {
        /**
         * 是否是主键
         *
         * @return
         */
        boolean primaryKey() default false;

        /**
         * 是否允许为空
         *
         * @return
         */
        boolean isNull() default false;

        /**
         * 是否唯一
         *
         * @return
         */
        boolean unique() default false;
    }

    /**
     * SQL int字段
     */
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SQLInt {
        /**
         * 数据库表的列名称
         *
         * @return
         */
        String name() default "";

        /**
         * 字段约束条件--嵌套注解
         *
         * @return
         */
        Constraints constraint() default @Constraints;
    }

    /**
     * SQL String字段
     */
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SQLString {
        /**
         * 数据库表的列名称
         *
         * @return
         */
        String name() default "";

        /**
         * 列的字段长度
         *
         * @return
         */
        int value() default 0;

        /**
         * 字段约束条件--嵌套注解
         *
         * @return
         */
        Constraints constraint() default @Constraints;
    }
}
