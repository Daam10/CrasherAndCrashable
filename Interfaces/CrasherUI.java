package Interfaces;

public interface CrasherUI<ToBreakDeterminator> {
	boolean canCrash(Crashable crashable) throws IllegalArgumentException; // ���������� CrasherUI.canBreakDown(), ������ ������ ���� ��������� ��� ����� ������!
	ToBreakDeterminator getToBreakDeterminator();
}
