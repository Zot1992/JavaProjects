import java.util.Stack;


public class Control {

    public Control FindControlSansRecursion(Control root)
    {
        int indent=1; // отступ
        Stack<Control> stack = new Stack<Control>();
        stack.push(root);

        while(!stack.empty())
        {
            for(int i = 0; i<indent; i++) {
                System.out.print("  ");
            }
            Control current = stack.pop();
            System.out.println(current);
            indent++; // увеличивает отступ

            for (Control control_in: current.Controls);
            {
                stack.push(control);
            }
        }
        return null;
    }
}
