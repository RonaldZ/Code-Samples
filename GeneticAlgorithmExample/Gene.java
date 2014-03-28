package geneticAlgorithmExample;

public class Gene {
	private boolean[] gene = new boolean[4];
	
	public Gene(boolean equationPart){ //true asks for a number, false an operator.
		do{
			for(int i = 0; i < gene.length; i++)
				gene[i] = Math.random() < .56;
		}
		while(!isViable(equationPart));
	}
	
	public boolean isViable(boolean equationPart){
		if(equationPart)
			switch(this.toString()){
			case "0000":
				return true;
			case "0001":
				return true;
			case "0010":
				return true;
			case "0011":
				return true;
			case "0100":
				return true;
			case "0101":
				return true;
			case "0110":
				return true;
			case "0111":
				return true;
			case "1000":
				return true;
			case "1001":
				return true;
		}
		else
			switch(this.toString()){
			case "1010":
				return true;
			case "1011":
				return true;
			case "1100":
				return true;
			case "1101":
				return true;
		}
		
		return false;
	}

	public boolean[] getGene(){
		return gene;
	}
	
	public void changeGene(int i, boolean value){
		if(i < 4)
			gene[i] = value;
		else
			System.out.println("Invalid array input value for changeGene");
	}
	
	public String toString(){
		String temp = "";
		
		for(boolean i : gene){
			if(i)
				temp = temp + "1";
			else
				temp = temp + "0";
		}
		
		return temp;
	}
}
