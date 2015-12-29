package br.com.batista.hinarioceea;


import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

import br.com.batista.hinarioceea.R;

public class ExpListAdapter extends BaseExpandableListAdapter {
    LayoutInflater inflater;
    Context context;
    public String parentT = "Pai";
    public String childT = "Filho";
    Music[] musicas;

    public ExpListAdapter(Context context, Music[] musicas){
        this.context = context;
        this.musicas = musicas;
    }

    //Quantidade de Heads
    @Override
    public int getGroupCount() {
        return 3;
    }

    //Quantidade de Itens em cada Head
    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    //O que vai na HEAD
    @Override
    public Object getGroup(int groupPosition) {
        return musicas[groupPosition].get_name();
    }

    //O que vai em cada item da Head
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return musicas[groupPosition].get_lyric();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return musicas[groupPosition].get_id();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView == null){
            inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_parent, null);
        }
        TextView parentText = (TextView)convertView.findViewById(R.id.parentText);
        parentText.setText(musicas[groupPosition].get_name());
        parentText.setTextColor(Color.BLACK);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        //Parte Padrao do algoritmo
        if(convertView == null){
            inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //R.layout.ALGUMA_COISA - Recebe o arquivo de layout com o textView
            convertView = inflater.inflate(R.layout.list_child, null);
        }
        //Recebe o TextView que será exibido na lista
        //Esse TextView precisa de um layout separado
        TextView childText = (TextView)convertView.findViewById(R.id.childText);
        childText.setText(musicas[groupPosition].get_lyric());
        childText.setTextColor(Color.BLACK);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}