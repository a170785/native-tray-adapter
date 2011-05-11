package tray.mocks;

import java.awt.TrayIcon.MessageType;
import java.util.Collection;
import java.util.LinkedHashMap;

import org.apache.commons.lang.StringUtils;

import tray.NativeTray;

public class NativeTrayMock implements NativeTray {

	private String file;
	private String tooltip;
	private LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
	private StringBuffer operations = new StringBuffer();

	@Override
	public void nativeInit(String file, String tooltip) {
		this.file = file;
		this.tooltip = tooltip;
		
	}

	@Override
	public void nativeAddMenuItem(int i, String label) {
		linkedHashMap.put(i, label);
	}

	@Override
	public void nativeDisplayMessage(String title, String caption,
			MessageType info) {
		operations.append(String.format("nativeDisplayMessage(%s,%s,%s)", title, caption, info));
	}

	@Override
	public void nativeSetAutosize(boolean autosize) {
		operations.append("nativeSetAutosize("+autosize+")\n");
	}

	public String getFile() {
		return this.file;
	}

	public String getTooltip() {
		return this.tooltip;
	}

	public String getDeclaredMenuItems() {
		Collection<String> values = linkedHashMap.values();
		String[] array = values.toArray(new String[0]);
		
		return StringUtils.join(array,",");
	}

	public String getOperations() {
		return operations.toString().trim();
	}

}