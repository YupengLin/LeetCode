package AbstractFactory;

public class ColorFactory extends AbstractFactory {
	
	public Color getColor(String color){
		if(color.equalsIgnoreCase("Red")){
			return new Red();
		}else if(color.equalsIgnoreCase("Green")){
			return new Green();
		}else if(color.equalsIgnoreCase("Blue")){
			return new Blue();
		}
		return null;
	}
	Shape getShape(String shape){
		return null;
	}

}
