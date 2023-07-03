create table csgo.wuqi
(
    id                    int auto_increment
        primary key,
    name                  varchar(255) null,
    name_sc               varchar(255) null,
    description_sc        varchar(255) null,
    item_slot_sc          varchar(255) null,
    accurate_range        varchar(255) null,
    kill_award_percentage varchar(255) null,
    price                 int          null,
    clip_size_max         int          null,
    cycle_time            int          null,
    damage                int          null
);


