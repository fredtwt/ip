import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Dingus {
	public static String startLine = "\n--------------------------------------------------------------------";
	public static String endLine = "--------------------------------------------------------------------\n";
	public static String greeting = "\nDingus:	Oh it's you again...\nDingus:	What kind of trouble would you inconvenience me with this time?\n";
	public static List<Task> tasks = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Greet
		System.out.println(startLine + greeting + endLine);

		while (sc.hasNext()) {
			String input = sc.nextLine().toLowerCase();
			String[] words = input.split(" ");

			// Exit
			if (input.equals("bye")) {
				System.out.println(startLine + "\nDingus:	Please don't ever bother me again, bye\n" + endLine);
				sc.close();
				return;
			}

			if (words[0].equals("list")) {
				// Output List
				String output = startLine + "\nHere are the tasks in your list:";
				for (int i = 0; i < tasks.size(); i++) {
					int numbering = i + 1;
					output += "\n" + numbering + ". [" + tasks.get(i).getStatusIcon() + "] " + tasks.get(i);
				}
				output += "\n" + endLine;
				System.out.println(output);
			} else if (words[0].equals("mark")) {
				// Marking task as Done
				int pos = Integer.parseInt(words[1]) - 1;
				tasks.get(pos).mark();
				System.out.println(startLine + "\nHooray...you've finally completed this task:\n" + "["
						+ tasks.get(pos).getStatusIcon() + "] " + tasks.get(pos) + "\n" + endLine);
			} else if (words[0].equals("unmark")) {
				// Unmarking task
				int pos = Integer.parseInt(words[1]) - 1;
				tasks.get(pos).unmark();
				System.out
						.println(startLine + "\nFaking your completed tasks again? I've unmarked this task:\n"
								+ "[" + tasks.get(pos).getStatusIcon() + "] " + tasks.get(pos) + "\n" + endLine);

			} else {
				// Adding Tasks
				Task currTask = new Task(input);
				tasks.add(currTask);
				System.out.println(startLine + "\nadded:	" + currTask + "\n" + endLine);
			}
		}

		sc.close();
	}

}
