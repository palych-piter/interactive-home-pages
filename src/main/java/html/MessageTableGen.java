package html;

import core.vMessageList;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Andrey on 11/7/2015.
 */
public class MessageTableGen {

    Method method;
    Object valueToReturn;
    //variable to define a getter name
    private String getterName = new String();

    public void printMessageTable(List list, Writer out)
            throws IOException {

        Field[] allfields = vMessageList.class.getDeclaredFields();
        //out.write("Fields are: " + Arrays.toString(allfields));

        out.write("<table border=1>");

        //Generate table header
        out.write("<tr>");
        for (Field field : allfields) {
            out.write("<td>");
            out.write(field.getName());
            out.write("</td>");
        }
        out.write("</tr>");

        for (Iterator iterator =
             list.iterator(); iterator.hasNext(); ) {
            vMessageList msg = (vMessageList) iterator.next();

            //Populate the table with real values
            out.write("<tr>");
            for (Field field : allfields) {
                out.write("<td>");
                //Define a name of getter based on field's name
                getterName = "get" + field.getName();

                try {
                    method = msg.getClass().getMethod(getterName);
                } catch (SecurityException e) {
                    System.out.printf("Security Exception while " +
                            "identifying a method.");
                } catch (NoSuchMethodException e) {
                    System.out.printf("Method " +
                            getterName + " is not found.");
                }

                try {

                    valueToReturn = method.invoke(msg);
                    out.write(valueToReturn.toString());

                } catch (IllegalArgumentException e) {
                } catch (IllegalAccessException e) {
                    System.out.printf("Illegal access exception.");
                } catch (InvocationTargetException e) {
                    System.out.printf("Target exception.");
                }

                out.write("</td>");
            }

                 /* out.write("<td>");
                  String str;
                  str = msg.getuser().name.toString();
                  out.write(str);
                 out.write("</td>"); */

            out.write("</tr>");

        }
        out.write("</table>");
    }
}
