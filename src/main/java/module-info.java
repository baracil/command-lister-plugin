
import jplugman.api.Plugin;
import perobobbot.commandlister.JPlugin;

module perobobbot.commandlister {
    requires static lombok;
    requires java.desktop;

    requires jplugman.api;
    requires com.google.common;

    requires perobobbot.extension;
    requires perobobbot.eventsub;
    requires perobobbot.lang;
    requires perobobbot.oauth;
    requires perobobbot.http;
    requires perobobbot.chat.core;
    requires perobobbot.twitch.client.api;
    requires perobobbot.messaging;
    requires perobobbot.command;
    requires perobobbot.data.service;
    requires perobobbot.plugin;
    requires perobobbot.access;

    provides Plugin with JPlugin;
}
