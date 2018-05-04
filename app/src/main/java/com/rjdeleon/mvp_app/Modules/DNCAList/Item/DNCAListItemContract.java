package com.rjdeleon.mvp_app.Modules.DNCAList.Item;

public interface DNCAListItemContract {
    interface View {
        void setHead(String head);

        void setDesc(String desc);

        void bind(DNCAListItemContract.Presenter presenter);

        void onDownloadDnca(String url);
    }
    interface Presenter {
        void downloadDnca(android.view.View view);
    }
}
