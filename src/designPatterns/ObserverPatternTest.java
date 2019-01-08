package designPatterns;

public class ObserverPatternTest {
public void test(MyTopic topic, String name)
{
	
	Observer obj1 = new TopicSubscriber(name);
	topic.register(obj1);
	obj1.setSubject(topic);
	obj1.update();
}
	public static void main(String[] args) {
		//create subject
		MyTopic topic = new MyTopic();
		
		//create observers
		
		/*Observer obj2 = new TopicSubscriber("Obj2");
		Observer obj3 = new TopicSubscriber("Obj3");
		
		//register observers to the subject
		
		topic.register(obj2);
		topic.register(obj3);
		
		//attach observer to subject
		
		obj2.setSubject(topic);
		obj3.setSubject(topic);*/
		ObserverPatternTest test=new ObserverPatternTest();
		//check if any update is available
		for(int i=0; i<4; i++)
		{
			test.test(topic, "obj"+i);
		}
		
		//now send message to subject
		topic.postMessage("New Message");
	}
}
