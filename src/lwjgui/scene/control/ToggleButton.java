package lwjgui.scene.control;

import lwjgui.event.ButtonEvent;

public abstract class ToggleButton extends ButtonBase implements Toggle {
	protected boolean selected;
	protected ToggleGroup toggleGroup;
	
	public ToggleButton( String name ) {
		this(name, null);
	}

	public ToggleButton(String name, ToggleGroup group) {
		super(name);

		this.setOnAction(new ButtonEvent() {
			@Override
			public void onEvent() {
				setSelected(true);
			}
		});
		
		this.setToggleGroup(group);
	}
	
	/**
	 * Sets the toggle group of this button.
	 * @param g
	 */
	public void setToggleGroup( ToggleGroup g ) {
		this.toggleGroup = g;
		g.add(this);
	}

	/**
	 * Sets whether or not this button is selected.
	 * <br>
	 * If it belongs to a ToggleGroup, only one button can be selected at a time.
	 * @param b
	 */
	public void setSelected(boolean b) {
		this.selected = b;
		
		if ( this.toggleGroup != null && b && (this.toggleGroup.getCurrectSelected()==null || !this.toggleGroup.getCurrectSelected().equals(this)) ) {
			this.toggleGroup.selectToggle(this);
		}
	}
	
	/**
	 * 
	 * @return Returns whether or not the button is selected.
	 */
	public boolean isSelected() {
		return this.selected;
	}
}
