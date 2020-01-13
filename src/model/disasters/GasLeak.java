package model.disasters;

import exceptions.BuildingAlreadyCollapsedException;
import exceptions.CitizenAlreadyDeadException;
import model.infrastructure.ResidentialBuilding;


public class GasLeak extends Disaster {

	public GasLeak(int startCycle, ResidentialBuilding target) {
		super(startCycle, target);
	}
	
	@Override
	public void strike() throws  BuildingAlreadyCollapsedException, CitizenAlreadyDeadException
	{
	
		ResidentialBuilding target= (ResidentialBuilding)getTarget();
		if(target.getStructuralIntegrity()==0)
		{
			BuildingAlreadyCollapsedException a =new BuildingAlreadyCollapsedException(this,"BuildingAlreadyCollapsed");
			throw a;}
		else {
			
			super.strike();
		target.setGasLevel(target.getGasLevel()+10);
		}
	}
	@Override
	public void cycleStep() {
		ResidentialBuilding target= (ResidentialBuilding)getTarget();
		target.setGasLevel(target.getGasLevel()+15);
		
	}

}
