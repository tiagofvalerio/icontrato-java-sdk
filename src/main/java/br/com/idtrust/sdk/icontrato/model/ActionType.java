package br.com.idtrust.sdk.icontrato.model;

public enum ActionType {
    SIGN {
        public String toString() {
            return "SIGN";
        }
    },
    APPROVE {
        public String toString() {
            return "APPROVE";
        }
    };
}
