package guiComponents;

import javax.swing.JPanel;
import newDoorSystem.CabinetOpening;

public abstract class DoorValuesBox extends JPanel
{
   /************************/
   /*** Abstract Methods ***/
   /************************/
   
   public abstract boolean checkAllFields();
   public abstract double[] getValuesInArray();
   
   public abstract void fillTextFields( CabinetOpening pCabinetDoor );
   public abstract void clearAllFields();
   public abstract void setEditable( boolean pEditable );
   
   public abstract void addAllComponentsToPanel();
   public abstract void showBox();
   public abstract void hideBox();
}
