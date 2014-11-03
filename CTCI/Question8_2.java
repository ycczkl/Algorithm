
public class Question8_2 {
	public class CallHandler {
		private static CallHandler instance;
		
		private final int LEVELS = 3;
		
		private final int NUM_RESPONDENTS = 10;
		private final int NUM_MANAGERS = 4;
		private final int NUM_DIRECTORS = 2;
		
		List<List<Employee>> employeeLevels;
		
		List<List<Call>> callQueues;
		
		public static CallHandler getInstance() {
			if (instance == null) instance = new CalHandler();
			return instance;
		}
		
		public Employee getHandlerForCall(Call call) {
			
		}
		
		public void dispatchCall(Caller caller) {
			Call call = new Call(caller);
			dispatchCall(call);
		}
		
		public void dispatchCall(Call call) {
			Employee emp = getHandlerForCall(call);
			if (emp != null) {
				emp.receiveCall(call);
				call.setHandler(emp);
			} else {
				call.reply("Please wait for free employee to reply");
				callQueues.get(call.getRank().getValue()).add(call);
			}
		}
		
		public boolean assignCall(Employee emp){};
	}
	
	public class Call {
		private Rank rank;
		
		private Caller caller;
		
		private Employee handler;
		
		public Call(Caller c) {
			rank = Rank.Responder;
			caller = c;
		}
	}
	
	abstract class Employee {
		private Call currentCall = null;
		protected Rank rank;
		
		public Employee() {};
		
		...
	}
	
	class Director extends Employee {
		public Director() {
			rank = Rank.Director;
		}
	}
	
	class Manager extends Employee {
		public Manager() {
			rank = Rank.Manager;
		}
	}
	
	class Respondent extends Employee {
		public Respondent() {
			rank = Rank.Responder;
		}
	}
}
