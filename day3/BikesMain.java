package com.org.genpact.assign.day3;




abstract class motorBike{
	
	String color;
	int model;
	
	public motorBike(String color, int model) {
		super();
		this.color = color;
		this.model = model;
	}
	
	abstract public void spped(int speed);
	abstract public void breaks(String breaks);
	abstract public void gear(int gears);
	
	public void bikeCompanyName(String companyname) {
		System.out.println("The company name: "+companyname);
	}
}


class SportsBike extends motorBike{

	public SportsBike(String color, int model) {
		super(color, model);
		
	}

	@Override
	public void spped(int speed) {
		System.out.println("The sports bike at speed: "+speed);
		
	}

	@Override
	public void breaks(String breaks) {
		System.out.println("The sports bike breaks through : "+breaks);
		
	}

	@Override
	public void gear(int gears) {
		System.out.println("The sports bike at gear at: "+gears);
		
	}
	
}



class MountainBike extends motorBike{

	public MountainBike(String color, int model) {
		super(color, model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void spped(int speed) {
		System.out.println("The sports bike at speed: "+speed);
		
	}

	@Override
	public void breaks(String breaks) {
		System.out.println("The sports bike breaks through : "+breaks);
		
	}

	@Override
	public void gear(int gears) {
		System.out.println("The sports bike at gear at: "+gears);
		
	}
	
}



class Waterbike extends motorBike{

	public Waterbike(String color, int model) {
		super(color, model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void spped(int speed) {
		System.out.println("The sports bike at speed: "+speed);
		
	}

	@Override
	public void breaks(String breaks) {
		System.out.println("The sports bike breaks through : "+breaks);
		
	}

	@Override
	public void gear(int gears) {
		System.out.println("The sports bike at gear at: "+gears);
		
	}	
}


public class BikesMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-------------------------");
		SportsBike sb = new SportsBike("red", 2012);
		sb.spped(100);
		sb.breaks("right brake");
		sb.gear(6);
		sb.bikeCompanyName("Honda");
		
		
		System.out.println("-------------------------");
		MountainBike mb = new MountainBike("Blue", 2022);
		mb.spped(80);
		mb.breaks("left brake");
		mb.gear(6);
		mb.bikeCompanyName("Ninja");
		
		System.out.println("-------------------------");
		Waterbike wb = new Waterbike("green", 2020);
		wb.spped(20);
		wb.breaks("right brake");
		wb.gear(6);
		wb.bikeCompanyName("waterLand");
		
		
		
	}

}
