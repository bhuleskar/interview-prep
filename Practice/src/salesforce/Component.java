package salesforce;

import java.util.HashSet;
import java.util.Set;

import org.hamcrest.core.Is;

//Remote Coding Test stage: implements components installer. Implement the following methods: 

//MakeDependency(component1, component2) // makes component1 dependent on component2

//Install(component1) // installs component1 and components it is dependent upon (if they're not installed already)

//Remove(component2) // removes component2 and components it is dependent upon if they're not used by other installed components.

//Note: component1 can be dependent on component2 and component3; and component4 can be dependent on component2


public class Component {
	
	private String name;
	private Set<Component> dependencies;
	private Set<Component> dependents;
	private boolean isInstalled;

	
	public Component(String name){
		this.name = name;
		dependencies = new HashSet<>();
		dependents = new HashSet<>();
		isInstalled = false;
	}
	
	// makes component1 dependent on component2
	public void MakeDependency(Component component){
		if(component == null) System.err.println("Dependency is null");
		
		this.dependencies.add(component);
		component.dependents.add(this);
	}
	
	public void Install() {
		Component.Install(this);
	}
	
	private static void Install(Component component) {
		if (component.isInstalled) 
			return;
		for (Component c : component.dependencies) {
			if (c.isInstalled) continue;
			Install(c);
		}
		component.isInstalled = true;
	}
	
	public void remove() {
		Component.remove(this);
	}
	
	private static void remove(Component component) {
		Set<Component> temp = new HashSet<>(component.dependencies.size());
		temp.addAll(component.dependencies);

		if (component.dependents.isEmpty()) {
			component.isInstalled = false;
			for (Component dep : component.dependencies) {
				dep.dependents.remove(component);
			}
			component.dependencies.clear();
		}
		
		for (Component c : temp) {
			Component.remove(c);
		}
	}
	
	
	public void listDependency(){
		System.out.println(name + " installed : " + isInstalled);
		for(Component dependency : this.dependencies)
			System.out.println(dependency.name+" : "+dependency.isInstalled);
	}
	
	public void getDependencies () {}
	public void getDependents () {}
	
	public static void main(String[] args) {
		//Create component objects
		Component c1 = new Component("C1");
		Component c2 = new Component("C2");
		Component c3 = new Component("C3");
		Component c4 = new Component("C4");
//		Components c5 = new Components("C5");
		
//		//Test case - 1 
//		//Make dependencies
//		c1.MakeDependency(c2);
//		c2.MakeDependency(c3);
//		c2.MakeDependency(c4);
//		
//		System.out.println("List dependencies for c1 before installing");
//		c1.listDependency();
//		
//		//Install C1. Should install C2,C3,C4 
//		c1.Install();
//		
//		System.out.println("List dependencies for c1 after installing");
//		c1.listDependency();
//		System.out.println("List dependencies for c2 after installing");
//		c2.listDependency();
//		
		
		//Test case - 2
		c1.MakeDependency(c2);
		c1.MakeDependency(c3);
		c4.MakeDependency(c2);
		
		System.out.println("List dependencies for c1 before installing");
		c1.listDependency();
		System.out.println("Install C1. Should install C2,C3"); 
		c1.Install();
		System.out.println("List dependencies for c1 after installing");
		c1.listDependency();
		System.out.println("Install C4.Since Should install C2");
		c4.Install();	
		System.out.println("List dependencies for c4 after installing");
		c4.listDependency();
		
		c1.remove();
		System.out.println("remove c1");
		c1.listDependency();
		c2.listDependency();
		c3.listDependency();
		c4.listDependency();
		
		
	}

}
