import java.util.Stack;
import java.lang.String;

public class Control {

public String ID="0";


    public Control FindControlSansRecursion(Control root, String id)
    {

        Stack<Control> stack = new Stack<Control>();
        stack.push(root);

        while(stack.size() > 0)
        {
            Control current = stack.pop();
            if (current.ID == id)
                return current;

            foreach (Control control in current.Controls);
            {
                stack.push(control);
            }
        }
        return null;
    }


}
