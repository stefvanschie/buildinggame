grammar Placeholders;

placeholder
    : players
    | has_booster
    | booster_multiplier
    | booster_time_left
    | booster_activator
    | stat
    | stat_top ;

players : PLAYERS ;

has_booster : HAS_BOOSTER ;
booster_multiplier : BOOSTER_MULTIPLIER ;
booster_time_left : BOOSTER_TIME_LEFT ;
booster_activator : BOOSTER_ACTIVATOR ;

stat : STAT identifier ;
stat_top : STAT identifier TOP number ;

PLAYERS : 'buildinggame_players' ;

HAS_BOOSTER : 'buildinggame_has_booster' ;
BOOSTER_MULTIPLIER : 'buildinggame_booster_multiplier' ;
BOOSTER_TIME_LEFT : 'buildinggame_booster_time_left' ;
BOOSTER_ACTIVATOR : 'buildinggame_booster_activator' ;

STAT : 'buildinggame_stat_' ;
TOP : '_top_' ;

TOKEN : 'a'..'z' | '_' ;
DIGIT : '0'..'9' ;

identifier : TOKEN+ ;
number : DIGIT+ ;