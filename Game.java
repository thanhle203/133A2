package com.mycompany.a2;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

public class Game extends Form {
	
	private GameWorld gw;
	private GameWorldProxy gwp;
	private MapView mv;
	private ScoreView sv;
	
	// method to instantiate a game
	public Game() {
		
		// create new instances of game world, game world proxy, map view, and score view
		gw = new GameWorld();
		gwp = new GameWorldProxy(gw);
		mv = new MapView(gwp);
		sv = new ScoreView(gwp);
		
		// add the appropriate classes to their observable
		gw.addObserver(gwp);
		gwp.addObserver(mv);
		gwp.addObserver(sv);
		
		// Set layout for form and create a new toolbar
		this.setLayout(new BorderLayout());
		
		Toolbar tool = new Toolbar();
		this.setToolbar(tool);
		tool.setTitle("Ant Game Version 2");
		
		// create new containers for buttons on south, east, and west of borders
		Container cpSouth = new Container(new FlowLayout(Component.CENTER));
		Container cpEast = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		Container cpWest = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		
		cpEast.getAllStyles().setPadding(Component.TOP, 50);
		cpWest.getAllStyles().setPadding(Component.TOP, 50);
		
		
		
		// create new instances of all commands
		Accelerate acc = new Accelerate(gw);
		Sound snd = new Sound(gw);
		About abt = new About(gw);
		Exit ex = new Exit(gw);
		CollideWithSpider sp = new CollideWithSpider(gw);
		CollideWithFlag fg = new CollideWithFlag(gw);
		CollideWithFoodStation fs = new CollideWithFoodStation(gw);
		Tick tk = new Tick(gw);
		RightTurn rt = new RightTurn(gw);
		LeftTurn lt = new LeftTurn(gw);
		Brake bk = new Brake(gw);
		Help hp = new Help(gw);
		
		// create a check box for toggling sound
		CheckBox soundChk = new CheckBox("Sound");
		soundChk.setSelected(false);
		soundChk.setCommand(snd);
		
		// add the appropriate commands to the side menu on the left of toolbar
		tool.addCommandToLeftSideMenu(acc);
		tool.addComponentToLeftSideMenu(soundChk);
		tool.addCommandToLeftSideMenu(abt);
		tool.addCommandToLeftSideMenu(ex);
		
		// add appropriate command to the right side of the toolbar
		tool.addCommandToRightBar(hp);
		
		// create buttons for all of the commands necessary to game
		ButtonStyle spb = new ButtonStyle("Collide With Spider");
		ButtonStyle fgb = new ButtonStyle("Collide With Flag");
		ButtonStyle fsb = new ButtonStyle("Collide With Food Station");
		ButtonStyle accb = new ButtonStyle("Accelerate");
		ButtonStyle bkb = new ButtonStyle("Brake");
		ButtonStyle rtb = new ButtonStyle("Right Turn");
		ButtonStyle ltb = new ButtonStyle("Left Turn");
		ButtonStyle tkb = new ButtonStyle("Tick");
		
		// assign the buttons to their respective commands
		spb.setCommand(sp);
		fgb.setCommand(fg);
		fsb.setCommand(fs);
		accb.setCommand(acc);
		bkb.setCommand(bk);
		rtb.setCommand(rt);
		ltb.setCommand(lt);
		tkb.setCommand(tk);
		
		// add buttons to the correct panel around center container
		cpEast.add(bkb);
		cpEast.add(rtb);
		
		cpWest.add(accb);
		cpWest.add(ltb);
		
		cpSouth.add(fgb);
		cpSouth.add(spb);
		cpSouth.add(fsb);
		cpSouth.add(tkb);
		
		
		
		// add key binding listener to invoke commands according to the key pressed
		addKeyListener((int)'a', acc);
		addKeyListener((int)'b', bk);
		addKeyListener((int)'l', lt);
		addKeyListener((int)'r', rt);
		addKeyListener((int)'f', fs);
		addKeyListener((int)'g', sp);
		addKeyListener((int)'t', tk);
		
		// add map view, score view, and panels to their respective locations
		this.add(BorderLayout.NORTH, sv);
		this.add(BorderLayout.CENTER, mv);
		this.add(BorderLayout.SOUTH, cpSouth);
		this.add(BorderLayout.EAST, cpEast);
		this.add(BorderLayout.WEST, cpWest);
		
		this.show();
		
		// set dimensions of game world to dimensions of map view container
		this.gw.setDimensions(mv.getWidth(), mv.getHeight());
		
		
		
	}
	
	
	
		
	
	
	
	
}

