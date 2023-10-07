package com.jellied.autocomplete;

import net.minecraft.src.client.gui.GuiChat;

import java.util.ArrayList;
import java.util.List;

public class CommandTimeAutocomplete implements CommandAutocomplete {
    final List<String> times =  new ArrayList<>();
    final List<String> operations = new ArrayList<>();
    final List<String> blankList = new ArrayList<>();

    public CommandTimeAutocomplete() {
        operations.add("add");
        operations.add("set");

        times.add("day");
        times.add("noon");
        times.add("sunset");
        times.add("night");
    }

    @Override
    public List<String> getCommandSuggestions(GuiChat gui) {
        int commandArgIndex = AutocompleteModClient.getCursorArgIndex(gui.chat.text, gui.chat.cursorPosition);
        if (commandArgIndex == 1) {
            return operations;
        }

        String[] commandArgs = gui.chat.text.split(" ");
        if (commandArgIndex == 2 && commandArgs[1].equals("set")) {
            return times;
        }

        return blankList;
    }
}