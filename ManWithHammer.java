import Interfaces.Crashable;
import Interfaces.CrasherUI;

public class ManWithHammer implements CrasherUI<Integer>{
	private Integer power;
	private ManWithHammerComparator comparator = new ManWithHammerComparator();
	
	public ManWithHammer(Integer power){
		this.power = power;
	}
	
	public ManWithHammer(){
		power = 50;
	}
	
	@Override
	public boolean canCrash(Crashable crashable) throws IllegalArgumentException {
		return comparator.canCrash(this, crashable);
	}
	
	@Override
	public String toString(){
		return "Hammer-" + power;
	}

	public Integer getToBreakDeterminator() {
		return power;
	}
}