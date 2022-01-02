db.createUser({
    user: 'root',
    pwd: 'root',
    roles: [
        {
            role: 'readWrite',
            db: 'rentx',
        },
    ],
});

db = new Mongo().getDB("rentx");

db.createCollection('account', { capped: false });
