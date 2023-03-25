package com.mycompany.maze_solver;

import javax.swing.*;
import java.util.*;
import java.awt.Graphics;
import java.awt.Color;

public class Maze_Solver extends JFrame{
    
    private int[][] maze =
    {
        {1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,1,1,1,1,1,0,0,0,0,0,1},
        {1,0,0,1,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,0,0,1},
        {1,0,1,0,1,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,9,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1},        
    };
    
    public List<Integer> path = new ArrayList<>();
    
    public Maze_Solver(){
        setLayout(null);
        
        setTitle("Maze Solver");
        setSize(640, 500);
        setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        DFS.searchPath(maze, 1, 1, path);
    }
    
    @Override
    public void paint(Graphics g){
        g.translate(50, 50);
//        to set the origin of our content in frame
        
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                Color color;
                switch(maze[i][j]){
                    case 1: color = Color.BLACK;break;
                    case 9: color = Color.RED;break;
                    default: color = Color.WHITE;break;
                }
                g.setColor(color);
                g.fillRect(30*j, 30*i, 30, 30);
                g.setColor(Color.RED);
                g.drawRect(30*j, 30*i, 30, 30);
            }
        }
        
        for(int i = 0; i < path.size(); i += 2){
            int xpath = path.get(i);
            int ypath = path.get(i + 1);
            
            g.setColor(Color.GREEN);
            g.fillRect(30*xpath, 30*ypath, 30, 30);
        }
    }

    public static void main(String[] args){
        Maze_Solver view = new Maze_Solver();
    }
}
